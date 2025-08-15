package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "portfolio",
        uniqueConstraints = @UniqueConstraint(name = "uk_portfolio_client", columnNames = "clientId")
)
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolioId")
    private Long portfolioId;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId", nullable = false,
            foreignKey = @ForeignKey(name = "fk_portfolio_client"))
    private Client client;

    @Column(name = "creationDate", nullable = false)
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();

    public Portfolio() {}

    public Portfolio(Client client, LocalDateTime creationDate, List<Security> securities) {
        this.portfolioId = null;
        this.client = client;
        this.creationDate = creationDate;
        if (securities != null) this.securities = securities;
    }

    public Long getPortfolioId() { return portfolioId; }
    public Client getClient() { return client; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public List<Security> getSecurities() { return securities; }

    public void setClient(Client client) { this.client = client; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
