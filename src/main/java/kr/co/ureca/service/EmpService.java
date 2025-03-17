package kr.co.ureca.service;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Emp> empFindAll() {
        List<Emp> list = empRepository.findAll();
        return list;
    }

    public Emp empFindByName(String ename) {
        Emp empEntity = empRepository.findByEname(ename);
        return empEntity;
    }

    public Emp empFindByNameAndSal(String ename, Integer sal) {
        Emp empEntity = empRepository.findByEnameAndSal(ename, sal);
        return empEntity;
    }

    public Emp empFindByNameAndJobAndSal(String ename, String job, Integer sal) {
        Emp empEntity = empRepository.findByEnameAndJobAndSal(ename, job, sal);
        return empEntity;
    }

    public List<Emp> empFindByNameOrJobOrSal(String ename, String job, Integer sal) {
        List<Emp> list = empRepository.findByEnameOrJobOrSal(ename, job, sal);
        return list;
    }

    public List<Emp> empFindByJobLike(String job) {
        List<Emp> list = empRepository.findByJobLike(job);
        return list;
    }

    public Long empInsert(Emp newEmp) {
        Emp saveAfterEmp = empRepository.save(newEmp);
        return saveAfterEmp.getId();
    }

    public Emp empUpdate(Emp newEmp) {
        //pk가지고 empEntity 찾은 후, empEntity에 set해줘야함
        Emp empEntity = empRepository.findById(newEmp.getId()).get();
        empEntity.setEname(newEmp.getEname());
        empEntity.setJob(newEmp.getJob());
        empEntity.setSal(newEmp.getSal());
        empEntity.setComm(newEmp.getComm());
        empEntity.setDeptno(newEmp.getDeptno());
        Emp empAfterUpdate = empRepository.save(empEntity);
        return empAfterUpdate;
    }

    public void empDelete(Emp empDel) {
        Optional<Emp> optEmp = empRepository.findById(empDel.getId());
        Emp empEntity = optEmp.get();
        empRepository.delete(empEntity);
    }

    public List<Emp> findByQueryJob(String job) {
        List<Emp> empList = null;
        empList = empRepository.findByJobParam(job);
        //위 아래 두 개는 같은 쿼리, 다른 표현, 다른 return 값
//        List<Object[]> list = empRepository.findByQueryJob(job);
//        empList = new ArrayList<>();
//        for(Object[] objs: list) {
//            Emp tmpEmp = new Emp();
//            tmpEmp.setId((Long) objs[0]);
//            tmpEmp.setEmpno((Integer) objs[1]);
//            tmpEmp.setEname((String) objs[2]);
//            tmpEmp.setJob((String) objs[3]);
//            tmpEmp.setMgr((Integer) objs[4]);
//            tmpEmp.setHiredate((String) objs[5]);
//            tmpEmp.setSal((Integer) objs[6]);
//            tmpEmp.setComm((Integer) objs[7]);
//            tmpEmp.setDeptno((Integer) objs[8]);
//            empList.add(tmpEmp);
//        }
        return empList;
    }



    public Emp findByQueryEname(String ename) {
        Emp empEntity = null;
        //아래 둘은 같은 쿼리, 다른 표현
//        empEntity = empRepository.findByQueryEname(ename);
        empEntity = empRepository.findByEnameParam(ename);
        return empEntity;
    }


}
