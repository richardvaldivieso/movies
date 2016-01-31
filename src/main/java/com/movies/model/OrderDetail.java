package com.movies.model;


public class OrderDetail {
    private Long orderDetailId;
    private Long OrderId;
    private Order order;
    private Long movieId;
    private Movie movie;
    private Double currentPrice;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetail that = (OrderDetail) o;

        if (orderDetailId != null ? !orderDetailId.equals(that.orderDetailId) : that.orderDetailId != null)
            return false;
        if (OrderId != null ? !OrderId.equals(that.OrderId) : that.OrderId != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (movieId != null ? !movieId.equals(that.movieId) : that.movieId != null) return false;
        if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
        return currentPrice != null ? currentPrice.equals(that.currentPrice) : that.currentPrice == null;

    }

    @Override
    public int hashCode() {
        int result = orderDetailId != null ? orderDetailId.hashCode() : 0;
        result = 31 * result + (OrderId != null ? OrderId.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + (currentPrice != null ? currentPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", OrderId=" + OrderId +
                ", order=" + order +
                ", movieId=" + movieId +
                ", movie=" + movie +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
