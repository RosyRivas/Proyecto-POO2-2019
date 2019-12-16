class ComponentesPelicula extends React.Component {

    constructor(props) {
        super(props);
        // estado del componente
        this.state = {
            //Listado de peliculas disponibles.
            peliculas: [],
            //Datos tomados del formulario.
            titulo: "",
            portada: "",
            duracion: "",
            sinopsis: "",
            //Pantallas
            agregarActoresCheck: false,
            agregarDirectoresCheck: false,
            agregarGenerosCheck: false,
            nuevaPelicula: false,
            //Listas de elementos a mostrar para checkear.
            actores: [],
            directores: [],
            generos: [],
            //Lista de elementos checkeados a guardar.
            actoresChecked: [],
            directoresChecked: [],
            generosChecked: []
        };
    }

    componentDidMount() {
        this.obtenerPeliculas();
    }
    //Se obtienen las peliculas disponibles.
    obtenerPeliculas() {
        fetch('/peliculas')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({peliculas: datos});
                        }
                );
    }
    //Se obtienen los actores para asociar a una pelicula. 
    obtenerActores() {
        fetch('/actor')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({actores: datos});
                        }
                );
    }
    //Se obtienen los directores para asociar a una pelicula.
    obtenerDirectores() {
        fetch('/director')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({directores: datos});
                        }
                );
    }
    //Se obtienen los generos para asociar a una pelicula.
    obtenerGeneros() {
        fetch('/generos')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({generos: datos});
                        }
                );
    }

    // estados cuando muestro el formulario de nueva Persona
    crearPeliculaFormulario() {
        this.setState({nuevaPelicula: true});
        this.setState({titulo: ""});
        this.setState({portada: ""});
        this.setState({duracion: ""});
        this.setState({sinopsis: ""});

    }

    agregarActores(evento) {
        evento.preventDefault();
        this.obtenerActores();
        this.setState({agregarActoresCheck: true});
        this.setState({nuevaPelicula: false});

    }

    agregarDirectores(evento) {
        evento.preventDefault();
        this.obtenerDirectores();
        this.setState({agregarDirectoresCheck: true});
        this.setState({nuevaPelicula: false}); 
    }

    agregarGeneros(evento) {
        evento.preventDefault();
        this.obtenerGeneros();
        this.setState({agregarGenerosCheck: true});
        this.setState({nuevaPelicula: false});
    }

    volverListado() {
        this.setState({nuevaPelicula: false});
        this.setState({agregarActoresCheck: false});
        this.setState({agregarDirectoresCheck: false});
        this.setState({agregarGenerosCheck: false});
    }

    crearPelicula() {
        fetch('/peliculas', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                    {
                        "idPelicula": "",
                        "titulo": this.state.titulo,
                        "portada": this.state.portada,
                        "duracion": this.state.duracion,
                        "sinopsis": this.state.sinopsis,
                        "actores": this.state.actoresChecked,
                        "directores": this.state.directoresChecked,
                        "generos": this.state.generosChecked
                    }
            )
        }
        );
        this.setState({nuevaPelicula: false});
        this.setState({actoresChecked: []});
        this.setState({directoresChecked: []});
        this.setState({generosChecked: []});
        this.setState({titulo: ""});
        this.setState({portada: ""});
        this.setState({duracion: ""});
        this.setState({sinopsis: ""});
        


    }

    manejadorCheckActoresPelicula(evento) {
        const target = evento.target;
        const id = target.id;
        var Longitud = this.state.actoresChecked.length;
        var tomarPreferencia = this.state.actoresChecked;
        var checkBox = document.getElementById(id);

        if (checkBox.checked == true) {
            tomarPreferencia[Longitud] = JSON.parse(checkBox.value);
            this.setState({actoresChecked: tomarPreferencia});
            console.log("Lista actores checked: " + JSON.stringify(this.state.actoresChecked));
        } else {
            let temporalFiltroActor = tomarPreferencia.filter(filtrar => filtrar !== JSON.parse(checkBox.value));
            this.setState({actoresChecked: temporalFiltroActor});
        }

    }

    manejadorCheckDirectoresPelicula(evento) {
        const target = evento.target;
        const id = target.id;
        var Longitud = this.state.directoresChecked.length;
        var tomarPreferencia = this.state.directoresChecked;
        var checkBox = document.getElementById(id);
        console.log("DirectorCheckeado: " + checkBox.value);

        if (checkBox.checked == true) {
            tomarPreferencia[Longitud] = JSON.parse(checkBox.value);
            this.setState({directoresChecked: tomarPreferencia});
            console.log("Lista directores checked: " + JSON.stringify(this.state.directoresChecked));
        } else {
            let temporalFiltroActor = tomarPreferencia.filter(filtrar => filtrar !== JSON.parse(checkBox.value));
            this.setState({actoresChecked: temporalFiltroActor});
        }
    }

    manejadorCheckGenerosPelicula(evento) {
        const target = evento.target;
        const id = target.id;
        var Longitud = this.state.generosChecked.length;
        var tomarPreferencia = this.state.generosChecked;
        var checkBox = document.getElementById(id);

        if (checkBox.checked == true) {
            tomarPreferencia[Longitud] = JSON.parse(checkBox.value);
            this.setState({generosChecked: tomarPreferencia});
            console.log("Lista generos checked: " + JSON.stringify(this.state.generosChecked));
        } else {
            let temporalFiltroActor = tomarPreferencia.filter(filtrar => filtrar !== JSON.parse(checkBox.value));
            this.setState({generosChecked: temporalFiltroActor});
        }
    }

    guardarActores(evento) {
        evento.preventDefault();
        this.setState({agregarActoresCheck: false});
        this.setState({nuevaPelicula: true});
    }

    guardarDirectores(evento) {
        evento.preventDefault();
        this.setState({agregarDirectoresCheck: false});
        this.setState({nuevaPelicula: true});
    }

    guardarGeneros(evento) {
        evento.preventDefault();
        this.setState({agregarGenerosCheck: false});
        this.setState({nuevaPelicula: true});
    }
    manejadorEntrada(evento) {

        const target = evento.target;
        const valor = target.value.toUpperCase();
        const nombre = target.name;
        this.setState({
            [nombre]: valor
        });
        console.log("estado: " + valor);
    }

    render() {
        if (this.state.nuevaPelicula) {
            return (
                    <div>
                        <p className="texto-resaltado"> Nueva pelicula</p>
                        <hr />                        
                        <form id="nueva-pelicula" onSubmit={this.crearPelicula.bind(this)}>                        
                            <div>
                                <label>Titulo:                                
                                    <input
                                        name="titulo"
                                        type="text"
                                        value={this.state.titulo}
                                        onChange={this.manejadorEntrada.bind(this)} />
                                </label>
                            </div>
                            <br/>
                            <div>
                                <label>Portada:                     
                                    <input
                                        name="portada"
                                        type="text"
                                        value={this.state.portada}
                                        onChange={this.manejadorEntrada.bind(this)} />
                                </label>                          
                            </div>
                            <br/>
                            <div>
                                <label>Duracion:                     
                                    <input
                                        name="duracion"
                                        type="text"
                                        value={this.state.duracion}
                                        onChange={this.manejadorEntrada.bind(this)} />
                                </label>                          
                            </div>
                            <br/>
                            <div>
                                <label>Sinopsis:                     
                                    <input
                                        name="sinopsis"
                                        type="text"
                                        value={this.state.sinopsis}
                                        onChange={this.manejadorEntrada.bind(this)} />
                                </label>                          
                            </div>
                            <hr />
                            <br/>
                            <div>
                                <button className="boton-simple" onClick={this.agregarActores.bind(this)}>Agregar actores</button>                        
                                <button className="boton-simple" onClick={this.agregarDirectores.bind(this)}>Agregar Directores</button>
                                <button className="boton-simple" onClick={this.agregarGeneros.bind(this)}>Agregar Generos</button>
                    
                            </div> 
                    
                            <hr />                    
                            <div>
                                <input className="boton-confirma" type="submit" value="Guardar"/>
                                <button className="boton-simple" onClick={this.volverListado.bind(this)}>Volver</button>
                            </div>
                        </form>  
                    </div>
                    );
        }

        if ((!this.state.nuevaPelicula && !this.state.agregarActoresCheck && !this.state.agregarDirectoresCheck) && !this.state.agregarGenerosCheck) {
            return (
                    <div>
            <div>
                        <button className="boton-simple" onClick={this.obtenerPeliculas.bind(this)}>Refrescar</button>                        
                        <button className="boton-nuevo" onClick={this.crearPeliculaFormulario.bind(this)}>Agregar</button>  
                        </div>
                        <br/>                        
                        <table>
                            <thead>
                                <tr>                    
                                    <th>Identificador</th>
                                    <th>Titulo</th>
                                    <th>Duracion</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.peliculas.map(pelicula =>
                                        <tr key = {pelicula.idPelicula}>
                                            <td> {pelicula.idPelicula} </td>
                                            <td> {pelicula.titulo} </td>
                                            <td> {pelicula.duracion} </td>
                                        </tr>
                        )}
                            </tbody>
                        </table>
                    </div>
                    );
        }

        if (this.state.agregarActoresCheck) {
            return (
                    <div>
                        <br/>                        
                        <table key="2">
                            <thead>
                                <tr>                    
                                    <th>IdActor</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.actores.map(actor =>
                                                <tr key = {actor.idActor}>
                                                    <td> {actor.idActor} </td>
                                                    <td> {actor.nombre} </td>
                                                    <td> {actor.apellido} </td>
                                                    <td> <input type="checkbox" id={"actores" + actor.idActor} value ={JSON.stringify(actor)} onClick={this.manejadorCheckActoresPelicula.bind(this)}/></td>
                                                </tr>
                                )}                                                        
                            </tbody>
                        </table>
                    
                        <div>
                            <button className="boton-verde" onClick={this.guardarActores.bind(this)} >Guardar</button>
                        </div>
                    </div>
                    );
        }
        if (this.state.agregarDirectoresCheck) {
            return (
                    <div>
                        <br/>                        
                        <table key="5">
                            <thead>
                                <tr>                    
                                    <th>IdDirector</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                 {this.state.directores.map(director =>
                                                <tr key = {director.idDirector}>
                                                    <td> {director.idDirector} </td>
                                                    <td> {director.nombre} </td>
                                                    <td> {director.apellido} </td>
                                                    <td> <input type="checkbox" id={"directores" + director.idDirector} value ={JSON.stringify(director)} onClick={this.manejadorCheckDirectoresPelicula.bind(this)}/></td>
                                                </tr>
                                )}                                                        
                            </tbody>
                        </table>
                    
                        <div>
                            <button className="boton-verde" onClick={this.guardarDirectores.bind(this)} >Guardar</button>
                        </div>
                    </div>
                    );
        }
        if (this.state.agregarGenerosCheck) {
            return (
                    <div>
                        <br/>                        
                        <table key="6">
                            <thead>
                                <tr>                    
                                    <th>IdGenero</th>
                                    <th>Descripcion</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.generos.map(genero =>
                                                <tr key = {genero.idGenero}>
                                                    <td> {genero.idGenero} </td>
                                                    <td> {genero.descripcion} </td>
                                                    <td> <input type="checkbox" id={"genero" + genero.idGenero} value ={JSON.stringify(genero)} onClick={this.manejadorCheckGenerosPelicula.bind(this)}/></td>
                                                </tr>
                                )}                                                        
                            </tbody>
                        </table>
                    
                        <div>
                            <button className="boton-verde" onClick = {this.guardarGeneros.bind(this)} >Guardar</button>
                        </div>
                    </div>
                    );
        }

    }
}

