/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class ComponentesCatalogo extends React.Component {
    constructor(props) {
        super(props);
        //estado del componente
        this.state = {
            //Listado de peliculas de un genero seleccionado.   
            peliculas: [],
            generos: [],
            //Lista de elenco y generos que pertenecen a una pelicula.
            //A ver..
            directoresPelicula: [],
            actoresPelicula: [],
            generosPelicula: [],
            //HTML render.
            obtenerPeliculas: false,
        };

    }
    componentDidMount() {
        this.obtenerGeneros();
    }
    // Se obtienen las peliculas segun el genero espcificado.
    obtenerPeliculas(idgenero) {
        console.log("Genero:" + idgenero);

        fetch('/peliculas/' + idgenero)
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({peliculas: datos});
                            console.log("Datos" + datos);
                        }
                );
    }

    //Lista de generos que pertenecen a una pelicula.
    obtenerGeneros() {
        fetch('/generos')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({generos: datos});
                        }
                );
    }

    obtenerPeliculasGenero(evento) {
        const target = evento.target;
        const valor = target.value;
        console.log("Genero:" + valor);
        this.obtenerPeliculas(valor);
        this.setState({obtenerPeliculas: true});

    }
    volverListadoGenero(){
        this.setState({obtenerPeliculas: false});
    }
   
    render() {
        if (this.state.obtenerPeliculas) {

            return(
                    <div>
            <div>
                    <button className="volver-relleno" onClick={this.volverListadoGenero.bind(this)}>Volver</button>
                    </div>

                        {this.state.peliculas.map(pelicula =>
                                                <div className="movie-card" key={pelicula.idPelicula}>
                                                    <div>
                                                        <img src={pelicula.portada} className = "movie-header"/>
                                                    </div>
                                                    <div className="movie-content">
                                                        <div className="movie-content-header">
                                                            <a href="#">
                                                                <h3 className="movie-title"> {pelicula.titulo}</h3>
                                                            </a>
                                                            <div className="pochoclo-logo"></div>
                                                        </div>
                                                        <div className="movie-info">
                                                            <div className="info-section">
                                                                <label>Duracion: </label>
                                                                <span>{pelicula.duracion}</span>
                                                            </div>            
                                                        </div>
                                                    </div>
                                                </div>)}
                    </div>

                    );
        }
        if (!this.state.obtenerPeliculas) {
            return (<div>
                <h2> Catálogo por genero </h2>
                         <h3>Buscar pelicula </h3>
                         <div className="search-container">
                    <form action="">
                      <input type="text" placeholder="Ingrese el titulo de la pelicula.." name="titulo"/>
                      <button type="submit" className="boton-azul">Buscar</button>
                    </form>
                  </div>   
                  <br/>
                {this.state.generos.map(genero =>
                                <div key = {genero.idGenero}>
                                    <button type="button" className="block" value = {genero.idGenero} onClick={this.obtenerPeliculasGenero.bind(this)}>{genero.descripcion}</button>
                                    <br/>
                                </div>
                            )}          
            </div>);
        }

    }

}
