package kr.co.ureca.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "emp")  //클래스 이름과 같다면 name 작성할 필요 x
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="empno")
    private Integer empno;

    @Column(name="ename")
    private String ename;

    @Column(name="job")
    private String job;

    @Column(name="mgr")
    private Integer mgr;

    @Column(name="hiredate")
    private String hiredate;

    @Column(name="sal")
    private Integer sal;

    @Column(name="comm")
    private Integer comm; //null값 존재하는 column은 보통 String으로 설정

    @Column(name="deptno")
    private Integer deptno;

//    public void setMgr(Integer mgr){
//        if(mgr == null) mgr = 0;
//        else this.mgr = mgr.intValue();
//    }

}
