package kr.co.ureca.controller;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 클라이언트과 통신을 주고 받아야 하기 때문에 controller는 보통 public.

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value="/empAll", method = RequestMethod.GET)
    public String empFindAll(){
        List<Emp> list = empService.empFindAll();
        System.out.println(list);
        return "hello";
    }

    @RequestMapping(value="/empByName", method = RequestMethod.GET)
    public String empFindByName(){
        String ename = "MILLER";
        String job = "CLERK";
        Integer sal = 1300;

        Emp empEntity = empService.empFindByName(ename);
        System.out.println("empFindByName: " + empEntity);

        empEntity = empService.empFindByNameAndSal(ename, sal);
        System.out.println("empFindByNameAndSal: " + empEntity);

        empEntity = empService.empFindByNameAndJobAndSal(ename, job, sal);
        System.out.println("empFindByNameAndJobAndSal: " + empEntity);

        List<Emp> list= empService.empFindByNameOrJobOrSal(ename, job, 3000);
        System.out.println("empFindByNameOrJobOrSal: " + list);

        list = empService.empFindByJobLike("SALES%");
        System.out.println("empFindBJobLike: " + list);

        return "hello";
    }

    @RequestMapping(value="/empIns", method = RequestMethod.GET)
    public String empInsert(){
        Emp newEmp = new Emp();
        newEmp.setEmpno(Integer.valueOf(9999));
        newEmp.setEname("HONG");
        newEmp.setJob("CLECK");
        newEmp.setSal(Integer.valueOf(1200));
        newEmp.setComm(Integer.valueOf(600));
        newEmp.setDeptno(Integer.valueOf(40));
        Long primaryKey = empService.empInsert(newEmp);
        System.out.println(primaryKey);
        return "hello";
    }

    @RequestMapping(value="empUp", method = RequestMethod.GET)
    public String empUpdate(){
        Emp newEmp = new Emp();
        newEmp.setId(16L);
        newEmp.setEmpno(Integer.valueOf(9999));
        newEmp.setEname("GilDong");
        newEmp.setJob("ANALYST");
        newEmp.setSal(Integer.valueOf(2400));
        newEmp.setComm(null);
        newEmp.setDeptno(Integer.valueOf(20));
        Emp empAfterUpdate = empService.empUpdate(newEmp);
        System.out.println(empAfterUpdate);
        return "hello";

    }

    @RequestMapping(value="/empDel", method=RequestMethod.GET)
    public String empDelete(){
        Emp empDel = new Emp();
        empDel.setId(16L);
        empService.empDelete(empDel);
        return "hello";
    }

    @RequestMapping(value="/empQuery", method=RequestMethod.GET)
    public String findByQuery(){
        String ename = "MARTIN";
        String job = "SALESMAN";
        Integer sal = 3000;

        Emp empEntity = empService.findByQueryEname(ename);
        System.out.println(empEntity);

        List<Emp> list = empService.findByQueryJob(job);
        System.out.println(list);

        return "hello";
    }
}
