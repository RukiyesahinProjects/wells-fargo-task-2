package com.wellsfargo.counselor.entity;
import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId")
    private Long clientId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "advisorId", nullable = false,
            foreignKey = @ForeignKey(name = "fk_client_advisor"))
    private Advisor advisor;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Portfolio portfolio;

    public Client() {}

    public Client(Advisor advisor, String firstName, String lastName,
                  String address, String phone, String email, Portfolio portfolio) {
        this.clientId = null;
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.portfolio = portfolio;
    }

    public Long getClientId() { return clientId; }
    public Advisor getAdvisor() { return advisor; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public Portfolio getPortfolio() { return portfolio; }

    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
