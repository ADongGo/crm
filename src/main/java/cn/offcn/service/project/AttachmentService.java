package cn.offcn.service.project;

import cn.offcn.entity.Attachment;
import cn.offcn.utils.OAResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.util.List;

public interface AttachmentService {

    /**
     * 保存附件
     * @param attachment
     * @param
     * @return
     */
    public OAResult saveAttachment(Attachment attachment, MultipartFile attachmentFile);

    /**
     * 查询所有附件
      * @return
     */
    public List<Attachment> queryAttachments();

    /**
     * 下载附件
     * @param id
     * @return
     * @throws Exception
     */
    public ResponseEntity<byte[]> downLoadAttachmentFile(int id) throws Exception;

    /**
     * 导出数据表格
     * @return
     */
    public OAResult exportData2Excle();
}
