package kr.co.ureca.repository;

import kr.co.ureca.entity.Emp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpRepository extends CrudRepository<Emp, Long> {

    public List<Emp> findAll();

    public Emp findByEname(String ename);

    public Emp findByEnameAndSal(String ename, Integer sal);

    public Emp findByEnameAndJobAndSal(String ename, String job, Integer sal);

    public List<Emp> findByEnameOrJobOrSal(String ename, String job, Integer sal);

    //자동으로 만들어주는 메소드가 아니고 개발자가 임의로 정의한 메소드
    //emp, EMP도 아닌 Emp로 작성해줘야함. Hibernate가 DB에서 가져와 EntityManager에 올려놓은 것들 대상으로 SELECT 하는 것이기 떼문에
    //속성을 List하면 하나의 row는 Object[]로 return됨.
//    @Query("SELECT e.id, e.empno, e.ename, e.job, e.hiredate, e.sal, e.comm, e.deptno" +
//            " FROM Emp e where e.job = ?1")
//    public List<Object[]> findByQueryJob(String job);


    @Query("SELECT e FROM Emp e where e.job =  :jobName")
    public List<Emp> findByJobParam(@Param("jobName") String job);

    @Query("SELECT e FROM Emp e where e.ename = ?1")
    public Emp findByQueryEname(String ename);

    @Query("SELECT e FROM Emp e where e.ename = :name")
    public Emp findByEnameParam(@Param("name") String ename);

    public List<Emp> findByJobLike(String job);

}
