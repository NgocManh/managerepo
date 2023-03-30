package com.example.testhiber.modelHiber;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction_detail")
@Builder
@Data
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    Long quantity;

    @JsonManagedReference
    @OneToMany(mappedBy = "transactionDetail",fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL)
    List<DeviceInfo> deviceInfoList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    Transaction transaction;

}
