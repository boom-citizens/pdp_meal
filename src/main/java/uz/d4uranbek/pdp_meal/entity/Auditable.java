package uz.d4uranbek.pdp_meal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    //@Column(name = "created_at", updatable = false)
    //@ColumnDefault(value = "CURRENT_TIMESTAMP")
    //@Generated(GenerationTime.INSERT)
    @Column(name = "created_by")
    private Long createBy;

    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Convert(disableConversion = true)
    @Column(name = "updated_at")
    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;


    public Auditable(Long createBy, LocalDateTime createdAt) {
        this.createBy = createBy;
        this.createdAt = createdAt;
    }
}