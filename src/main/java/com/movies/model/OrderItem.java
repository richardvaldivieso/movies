package com.movies.model;


import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "orderitemid")
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderid")
    private Order order;

    @OneToOne
    @JoinColumn(name="movieid")
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

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
