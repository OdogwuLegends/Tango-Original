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
@Table(name = "individual_kyc")
public class IndividualKyc extends BaseEntity {
    @OneToOne
    private File validIdCard;

    @OneToOne
    private File proofOfAddress;

    @OneToOne
    private File liveImage;
}
