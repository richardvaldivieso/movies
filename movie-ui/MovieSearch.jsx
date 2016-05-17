import React from 'react';
import MovieList from './MovieList.jsx'
import { connect, PromiseState } from 'react-refetch'
import  'whatwg-fetch'

class MovieSearch extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            movies: [],
            searchTerm: '',
            newMovies: []
        }
    }

    componentDidMount() {
        fetch('movielist.json').then((response)=> {

            return response.json();
        }).then((json)=> {
            this.setState({movies: json.movies});

        })
    }

    render() {
        return (
            <div>
                <input type="text" onChange={this.searchMovies.bind(this)}/>
                {this.getMovies()}
            </div>
        )

    }

    searchMovies(e) {
        let searchTerm = e.target.value;
        console.log(e.target.value)

        let movies = this.state.movies;

        let movieList = movies.filter(movie => {
            return movie.movieName.toLowerCase().includes(searchTerm.toLowerCase());
        })

        this.setState({newMovies: movieList})


    }

    getMovies() {
        let movies = this.state.newMovies.length > 0 ? this.state.newMovies : this.state.movies;
        return (movies.map((movie, i)=> {
            return <div key={i}>{movie.movieName}</div>
        }))
    }
}

export default MovieSearch;
