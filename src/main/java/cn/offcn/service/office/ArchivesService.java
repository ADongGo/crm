package cn.offcn.service.office;

import cn.offcn.entity.Archives;
import cn.offcn.entity.Employee;
import cn.offcn.utils.OAResult;
import org.springframework.web.multipart.MultipartFile;

public interface ArchivesService {

    public void saveInfo(Employee employee, Archives archives);

    public OAResult importArchiveDataToDataBase(MultipartFile files);

    public Archives getArchivesByEid(int eid);
}
