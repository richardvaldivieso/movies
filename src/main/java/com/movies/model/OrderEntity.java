package com.movies.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OrderEntity {
    public OrderEntity(String orderStatus, Double discount){
        this.orderStatus = orderStatus;
        this.discount = discount;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="orderid")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name="customerid")
    private CustomerEntity customer;

    @Column(name="orderdate")
    private Date orderDate;

    @Column(name="orderstatus")
    private String orderStatus;

    @Column(name="discount")
    private Double discount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order", orphanRemoval = true)
    @OrderBy("id DESC")
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;
        return orderItems != null ? orderItems.equals(that.orderItems) : that.orderItems == null;

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        return result;
    }
}
