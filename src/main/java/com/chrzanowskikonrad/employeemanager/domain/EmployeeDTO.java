package com.chrzanowskikonrad.employeemanager.domain;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;

    public EmployeeDTO() {
    }

    private EmployeeDTO(Long id, String name, String email, String jobTitle, String phone, String imageUrl,
                        String employeeCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    private EmployeeDTO(Builder builder) {
        id = builder.id;
        name = builder.name;
        email = builder.email;
        jobTitle = builder.jobTitle;
        phone = builder.phone;
        imageUrl = builder.imageUrl;
        employeeCode = builder.employeeCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private String email;
        private String jobTitle;
        private String phone;
        private String imageUrl;
        private String employeeCode;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder employeeCode(String employeeCode) {
            this.employeeCode = employeeCode;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(this);
        }
    }
}
