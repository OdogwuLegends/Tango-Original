package com.tm30.tango.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "corporate_kyc")
public class CorporateKyc extends BaseEntity {
    private String companyName;
    private String companyAddress;
    private String rcNumber;

    @OneToOne
    private File cacDocument;
    @OneToOne
    private File companyTIN;
    @OneToOne
    private File proofOfAddress;
}
