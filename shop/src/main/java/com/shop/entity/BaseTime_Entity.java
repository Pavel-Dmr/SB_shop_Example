package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
// Auditing을 적용하기 위해 어노테이션 추가
@MappedSuperclass
// 공통 매핑 정보가 필요할때 사용하는 어노테이션 부모 클래스를 상속
// 받는 자식 클래스에 매핑정보만 제공

@Getter
@Setter
public class BaseTime_Entity {

    @CreatedDate // 엔티티가 생성되어 저장할 때 시간자동 저장
    @Column(updatable = false)
    private LocalDateTime reg_time;

    @LastModifiedDate
    private LocalDateTime update_time;


}

// 만드는 이유는 보통 테이블에 등록일 , 수정일 , 등록자 , 수정자를 모두 다 넣어주지만
// 어떤 테이블은 등록자 , 수정자르 넣지 않는 테이블도 있다.
// 그런 Entity는 BaseTimeEntity만 상속 받을 있도록 BaseTime_Entity 클래스를 생성