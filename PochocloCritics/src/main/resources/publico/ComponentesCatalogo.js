/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class ComponenteCatalogo extends React.Component{
    constructor (props){
        super (props);
        //estado del componente
        this.state = {
          //Listado de peliculas   
            peliculas: [],
            //Listado de peliculas segun distintos parametros( genero, actor, director)
            directoresPelicula: [],
            actoresPelicula: [],
            generosPelicula: []
          
            //HTML render.
            
            
        };
        
    }
    componentDidMount() {
        this.obtenerPeliculas();
    }
    // se obtienen las peliculas para clasificarlas 
       obtenerPeliculas() {
        fetch('/peliculas')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({peliculas: datos});
                        }
                );
    }
    
    
    //Lista de actores  para  clasificar peliculas .
    obtenerActores() {
        fetch('/actor')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({actores: datos});
                        }
                );
    }
     //Se obtienen los directores para clasificar una pelicula.
    obtenerDirectores() {
        fetch('/director')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({directores: datos});
                        }
                );
    }  
    //Se obtiene los generos para clasificar peliculas.
      obtenerGeneros() {
        fetch('/generos')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({generos: datos});
                        }
                );
    }
    
    visualizarListado(){
        this.setState(obtener );
        this.setState();
    }
    
    render(){
        if (this.state.obtenerPelicula){
            
            return(
                    <div>
            <h2> volver  </h2>
                <td><button className="boton-verde" onClick={this.obtenerSeccionPreferencia.bind(this, usuario.idUsuario)}>volver</button></td>     
                    </div>
                    
                    
                    
                    
                    )
             
        }
        
    }
    
    
}
