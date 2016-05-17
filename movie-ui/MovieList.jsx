import React from 'react';

class MovieList extends React.Component {
    render() {

        return <div>
            {this.props.movies.map((movie,i) =>{
                return <div key={i}>
                    <h3>{movie.movieName}</h3>
                </div>
            })}
        </div>
    }
}

export default MovieList;