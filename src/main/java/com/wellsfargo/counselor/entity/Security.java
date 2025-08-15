package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "securityId")
    private Long securityId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioId", nullable = false,
            foreignKey = @ForeignKey(name = "fk_security_portfolio"))
    private Portfolio portfolio;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "purchasePrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal purchasePrice;

    @Column(name = "purchaseDate", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "quantity", nullable = false, precision = 18, scale = 6)
    private BigDecimal quantity;

    public Security() {}

    public Security(Portfolio portfolio, String name, String category,
                    BigDecimal purchasePrice, LocalDate purchaseDate, BigDecimal quantity) {
        this.securityId = null;
        this.portfolio = portfolio;
        this.name = name;
        this.category = category;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
    }

    public Long getSecurityId() { return securityId; }
    public Portfolio getPortfolio() { return portfolio; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public BigDecimal getQuantity() { return quantity; }

    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
}