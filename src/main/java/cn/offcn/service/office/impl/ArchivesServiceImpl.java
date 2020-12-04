package cn.offcn.service.office.impl;

import cn.offcn.entity.Archives;
import cn.offcn.entity.ArchivesExample;
import cn.offcn.entity.Employee;
import cn.offcn.entity.EmployeeExample;
import cn.offcn.mapper.ArchivesMapper;
import cn.offcn.mapper.EmployeeMapper;
import cn.offcn.service.office.ArchivesService;
import cn.offcn.utils.OAResult;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArchivesServiceImpl implements ArchivesService {
    
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private ArchivesMapper archivesMapper;
    
    @Override
    public void saveInfo(Employee employee, Archives archives) {

        Employee oldEmployee = employeeMapper.selectByPrimaryKey(employee.getEid());
        oldEmployee.setEname(employee.getEname());
        oldEmployee.setEsex(employee.getEsex());
        employeeMapper.updateByPrimaryKey(oldEmployee);

        Archives oldArchives = archivesMapper.selectByPrimaryKey(archives.getDnum());
        oldArchives.setZhuanye(archives.getZhuanye());
        oldArchives.setZzmm(archives.getZzmm());
        oldArchives.setMinzu(archives.getMinzu());
        oldArchives.setSchool(archives.getSchool());
        oldArchives.setSosperson(archives.getSosperson());
        oldArchives.setEmail(archives.getEmail());
        archivesMapper.updateByPrimaryKey(oldArchives);
    }

    public OAResult importArchiveDataToDataBase(MultipartFile files){

        List<Archives> archiveList=new ArrayList<Archives>();
        try{
            if(files!=null){
                //获取上传文件的输入流
                InputStream inputStream=files.getInputStream();
                //创建一个excle文件对象
                HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
                //获取工作薄的数据
                int numberOfSheets = workbook.getNumberOfSheets();
                //循环每个工作薄
                for(int i=0;i<numberOfSheets;i++){
                    HSSFSheet sheetAt = workbook.getSheetAt(i);
                    if(sheetAt==null){
                        continue;
                    }
                    //获取该工作薄的最大行号
                    int lastRowNum = sheetAt.getLastRowNum();
                    for(int j=1;j<=lastRowNum;j++){
                        HSSFRow row = sheetAt.getRow(j);
                        HSSFCell dnum = row.getCell(0);
                        HSSFCell landline = row.getCell(1);
                        HSSFCell school = row.getCell(2);
                        HSSFCell zhuanye = row.getCell(3);
                        HSSFCell sosperson = row.getCell(4);
                        HSSFCell biyedate = row.getCell(5);
                        HSSFCell zzmm = row.getCell(6);
                        HSSFCell minzu = row.getCell(7);
                        HSSFCell xueli = row.getCell(8);
                        HSSFCell email = row.getCell(9);
                        HSSFCell empFk = row.getCell(10);
                        //创建一个档案类对象
                        Archives archives=new Archives();
                        archives.setDnum(dnum.getStringCellValue());
                        archives.setLandline(landline.getStringCellValue());
                        archives.setSchool(school.getStringCellValue());
                        archives.setZhuanye(zhuanye.getStringCellValue());
                        archives.setSosperson(sosperson.getStringCellValue());
                        archives.setBiyedate(biyedate.getDateCellValue());
                        archives.setZzmm(zzmm.getStringCellValue());
                        archives.setMinzu(minzu.getStringCellValue());
                        archives.setXueli(xueli.getStringCellValue());
                        archives.setEmail(email.getStringCellValue());
                        archives.setEmpFk((int)empFk.getNumericCellValue());
                        archiveList.add(archives);
                    }
                }
                inputStream.close();
            }
        }catch(Exception e){
            e.printStackTrace();
            return OAResult.ok(400,"导入失败");
        }

        if(archiveList.size()>0){
            int rows=archivesMapper.addBatchArchives(archiveList);
            if(rows==archiveList.size()){
                return OAResult.ok(200,"导入成功");
            }else{
                return  OAResult.ok(400,"导入失败");
            }
        }
        return  OAResult.ok(400,"导入失败");
    }

    public Archives getArchivesByEid(int eid){

        ArchivesExample archivesExample=new ArchivesExample();
        ArchivesExample.Criteria criteria = archivesExample.createCriteria();
        criteria.andEmpFkEqualTo(eid);
        List<Archives> archives = archivesMapper.selectByExample(archivesExample);
        if(archives!=null && archives.size()==1){
            return archives.get(0);
        }
        return null;
    }
}
