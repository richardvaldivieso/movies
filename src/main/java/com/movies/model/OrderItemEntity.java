package com.movies.model;


import javax.persistence.*;

@Entity
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "orderitemid")
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderid")
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name="movieid")
    private MovieEntity movie;

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    private Double currentPrice;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }


    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemEntity orderItem = (OrderItemEntity) o;

        if (!orderItemId.equals(orderItem.orderItemId)) return false;
        if (!order.equals(orderItem.order)) return false;
        if (!movie.equals(orderItem.movie)) return false;
        return currentPrice.equals(orderItem.currentPrice);

    }

    @Override
    public int hashCode() {
        int result = orderItemId.hashCode();
        result = 31 * result + order.hashCode();
        result = 31 * result + movie.hashCode();
        result = 31 * result + currentPrice.hashCode();
        return result;
    }
}
