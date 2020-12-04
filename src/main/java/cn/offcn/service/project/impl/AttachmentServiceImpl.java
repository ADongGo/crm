package cn.offcn.service.project.impl;

import cn.offcn.entity.Attachment;
import cn.offcn.entity.AttachmentExample;
import cn.offcn.entity.Project;
import cn.offcn.mapper.AttachmentMapper;
import cn.offcn.mapper.ProjectMapper;
import cn.offcn.service.project.AttachmentService;
import cn.offcn.utils.DateUtils;
import cn.offcn.utils.OAResult;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;
    @Autowired
    private ProjectMapper projectMapper;

    @Value("${uploadDir}")
    private String uploadDir;

    @Override
    public OAResult saveAttachment(Attachment attachment, MultipartFile attachmentFile) {

        if (attachmentFile != null) {
            try {
                String fileName = attachmentFile.getOriginalFilename();
                int hashCode = fileName.hashCode();
                int d1 = hashCode & 0xf;
                int d2 = (hashCode >> 2) & 0xf;
                uploadDir = uploadDir + "\\" + d1 + "\\" + d2;
                File saveDir = new File(uploadDir);
                if (!saveDir.exists()) saveDir.mkdirs();
                fileName = UUID.randomUUID().toString() + "&" + fileName;
                File saveFile = new File(saveDir, fileName);
                attachmentFile.transferTo(saveFile);
                attachment.setPath(saveFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                return OAResult.ok(400, "附件上传失败");
            }
            attachment.setUpdatetime(new Date());
            attachment.setUploadtime(new Date());
            int insert = attachmentMapper.insert(attachment);
            if (insert == 1) {
                return OAResult.ok(200, "附件保存成功");
            }

        }
        return OAResult.ok(400, "附件上传失败");
    }

    @Override
    public List<Attachment> queryAttachments() {

        List<Attachment> attachments = attachmentMapper.selectByExample(new AttachmentExample());
        for (Attachment attachment : attachments) {

            Project project = projectMapper.selectByPrimaryKey(attachment.getProFk());
            attachment.setProject(project);
        }

        return attachments;
    }

    @Override
    public ResponseEntity<byte[]> downLoadAttachmentFile(int id) throws Exception {

        Attachment attachment = attachmentMapper.selectByPrimaryKey(id);
        String filePath = attachment.getPath();
        //让到要下载的文件的File对象
        File downLoadFile = new File(filePath);
        //创建一个httpHeards
        HttpHeaders headers = new HttpHeaders();
        String fileName = attachment.getPath().substring(attachment.getPath().lastIndexOf("&") + 1);
        //进行编程设置，防止文件名乱码
        fileName = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
        //设置内容格式
        headers.setContentDispositionFormData("attachment", fileName);
        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(downLoadFile), headers, HttpStatus.OK);
    }

    @Override
    public OAResult exportData2Excle() {

        //构造一个excel文档对象
        HSSFWorkbook workbook=new HSSFWorkbook();
        //创建一个工作簿
        HSSFSheet sheet=workbook.createSheet("导出表格");
        //创建一行(对象)
        HSSFRow firstRow=sheet.createRow(0);
        //设置单元格样式
        HSSFCellStyle cellStyle=workbook.createCellStyle();
        //设置字体样式
        HSSFFont hssfFont=workbook.createFont();
        hssfFont.setFontName("宋体");
        hssfFont.setColor(Font.COLOR_RED);
        hssfFont.setBoldweight((short)(800));
        hssfFont.setFontHeightInPoints((short)12);
        cellStyle.setFont(hssfFont);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        HSSFCell[] firstRowColumns=new HSSFCell[6];
        for( int i=0;i<firstRowColumns.length;i++){
            firstRowColumns[i]=firstRow.createCell(i);
            firstRowColumns[i].setCellStyle(cellStyle);
        }
//设置每列的宽度
        sheet.setColumnWidth(0,5000);
        sheet.setColumnWidth(1,10000);
        sheet.setColumnWidth(2,10000);
        sheet.setColumnWidth(3,5000);
        sheet.setColumnWidth(4,5000);
        sheet.setColumnWidth(5,15000);

        //设置第一行的每个单元格列的数据
        firstRowColumns[0].setCellValue("编号");
        firstRowColumns[1].setCellValue("附件名称");
        firstRowColumns[2].setCellValue("所属项目");
        firstRowColumns[3].setCellValue("上传时间");
        firstRowColumns[4].setCellValue("修改时间");
        firstRowColumns[5].setCellValue("路径");

        List<Attachment> attachmentList=queryAttachments();
        for(int i=0;i<attachmentList.size();i++){
            HSSFRow row=sheet.createRow(i+1);
            HSSFCell[] rowColumns=new HSSFCell[6];
            for(int j=0;j<rowColumns.length;j++){
                rowColumns[j]=row.createCell(j);
            }
            rowColumns[0].setCellValue(attachmentList.get(i).getId());
            rowColumns[1].setCellValue(attachmentList.get(i).getAttname());
            rowColumns[2].setCellValue(attachmentList.get(i).getProject().getPname());
            rowColumns[3].setCellValue(DateUtils.Date2String(attachmentList.get(i).getUploadtime()));
            rowColumns[4].setCellValue(DateUtils.Date2String(attachmentList.get(i).getUpdatetime()));
            rowColumns[5].setCellValue(attachmentList.get(i).getPath());
        }

        try{
            FileOutputStream fos=new FileOutputStream("D:\\AAA_date\\workspace\\attachment\\excel\\attachment.xls");
            workbook.write(fos);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
            return OAResult.ok(400,"附件导出失败");
        }
        return OAResult.ok(200,"附件导出成功");
    }
}

