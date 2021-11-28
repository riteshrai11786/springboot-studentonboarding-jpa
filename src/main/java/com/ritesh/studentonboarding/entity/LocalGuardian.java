package com.ritesh.studentonboarding.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "local_guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "local_guardian_email")
        ),
        @AttributeOverride(
                name = "phone",
                column = @Column(name = "local_guardianphone")
        )
})
public class LocalGuardian {

    private String name;
    private String email;
    private String phone;
}
