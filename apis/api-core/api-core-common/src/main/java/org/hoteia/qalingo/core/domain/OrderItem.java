/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TECO_ORDER_ITEM")
public class OrderItem extends AbstractEntity {

    /**
     * Generated UID
     */
    private static final long serialVersionUID = 6982641911557993534L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID", insertable = true, updatable = true)
    private CurrencyReferential currency;
    
    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY", nullable = false, columnDefinition = "int(11) default 0")
    private int quantity;

    @Column(name = "PRODUCT_SKU_CODE")
    private String productSkuCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_SKU_ID", insertable = true, updatable = true)
    private ProductSku productSku;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_TAX_ID")
    private Set<OrderTax> orderTaxes = new HashSet<OrderTax>();

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public CurrencyReferential getCurrency() {
        return currency;
    }
    
    public void setCurrency(CurrencyReferential currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    public ProductSku getProductSku() {
        return productSku;
    }

    public void setProductSku(ProductSku productSku) {
        this.productSku = productSku;
    }

    public Set<OrderTax> getOrderTaxes() {
        return orderTaxes;
    }

    public void setOrderTaxes(Set<OrderTax> orderTaxes) {
        this.orderTaxes = orderTaxes;
    }
    
    public BigDecimal getTotalAmountOrderItem() {
        BigDecimal totalAmount = new BigDecimal("0");
        if (price != null) {
            totalAmount = totalAmount.add(price);
        }
        totalAmount = totalAmount.multiply(new BigDecimal(quantity));
        return totalAmount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((productSkuCode == null) ? 0 : productSkuCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (productSkuCode == null) {
            if (other.productSkuCode != null)
                return false;
        } else if (!productSkuCode.equals(other.productSkuCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", price=" + price + ", quantity=" + quantity + ", productSkuCode=" + productSkuCode + "]";
    }
}