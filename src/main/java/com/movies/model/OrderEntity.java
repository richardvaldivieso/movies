package com.movies.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="orderid")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name="customerid")
    private CustomerEntity customer;

    @Column(name="orderdate")
    private Date orderDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity order = (OrderEntity) o;

        if (!orderId.equals(order.orderId)) return false;
        if (!customer.equals(order.customer)) return false;
        if (!orderDate.equals(order.orderDate)) return false;
        return orderItems.equals(order.orderItems);

    }

    @Override
    public int hashCode() {
        int result = orderId.hashCode();
        result = 31 * result + customer.hashCode();
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + orderItems.hashCode();
        return result;
    }
}
