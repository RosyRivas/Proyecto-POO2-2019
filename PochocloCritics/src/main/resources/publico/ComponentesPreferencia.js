class ComponentesPreferencia extends React.Component {

    constructor(props) {
        super(props);
        // estado del componente
        this.state = {
            // Listado de usuarios a seleccionar para editar preferencia.   
            usuarios: [],
            //Listado de preferencias de un usuario especifico.
            directoresPreferencia: [],
            generosPreferencia: [],
            actoresPreferencia: [],

            //Listado de nuevas preferencias del usuario al checkearse (CheckBox)/
            nuevaPreferenciaActor: [],
            nuevaPreferenciaDirector: [],
            nuevaPreferenciaGenero: [],

            //Listado de preferencias a mostrar cuando el usuario quiere elegir más preferencias.
            actores: [],
            directores: [],
            generos: [],

            //Actores obtenidos al clickear un CheckBox.
            actorObtenido: '',
            directorObtenido: '',
            generoObtenido: '',

            //Elementos a ser eliminados al hacer click en el boton.
            actorEliminado: '',
            directorEliminado: '',
            generoEliminado: '',

            //IdPreferencia del usuario seleccionado.
            preferencia_usuario: "",

            //HTML render.
            obtenerPreferencia: false,
            editarPreferenciaActor: false,
            editarPreferenciaDirector: false,
            editarPreferenciaGenero: false

        };
    }

// se ejecuta al montar el componente
    componentDidMount() {
        this.obtenerUsuarios();
    }

//Lista de usuarios obtenidos de la BD. 
    obtenerUsuarios() {
        fetch('/usuarios')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({usuarios: datos});
                        }
                );
    }

//Lista de actores para que el usuario seleccione su preferencia.
    obtenerActores() {
        fetch('/actor')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({actores: datos});
                        }
                );
    }

//Lista de directores para que el usuario seleccione su preferencia.
    obtenerDirectores() {
        fetch('/director')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({directores: datos});
                        }
                );
    }

//Lista de generos para que el usuario seleccione su preferencia.
    obtenerGeneros() {
        fetch('/generos')
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({generos: datos});
                        }
                );
    }

//Seccion de preferencias del usuario indicado segun id.
    obtenerSeccionPreferencia(iduser) {
        fetch('/preferencias/' + iduser)
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            const id_preferencia = datos.idPreferencia;
                            const listaActores = datos.actor;
                            const listaDirectores = datos.director;
                            const listaGeneros = datos.genero;
                            this.setState({preferencia_usuario: id_preferencia});
                            this.setState({actoresPreferencia: listaActores});
                            this.setState({directoresPreferencia: listaDirectores});
                            this.setState({generosPreferencia: listaGeneros});
                            this.setState({obtenerPreferencia: true});

                        }
                );
    }

//Ir a seccion para elegir preferencia de Actores.
    obtenerPreferenciaActor() {
        this.obtenerActores();
        this.setState({obtenerPreferencia: false});
        this.setState({editarPreferenciaActor: true});
    }

//Ir a seccion para elegir preferencia de Directores.
    obtenerPreferenciaDirector() {
        this.obtenerDirectores();
        this.setState({obtenerPreferencia: false});
        this.setState({editarPreferenciaDirector: true});
    }

//Ir a seccion para elegir preferencia de Generos.
    obtenerPreferenciaGenero() {
        this.obtenerGeneros();
        this.setState({obtenerPreferencia: false});
        this.setState({editarPreferenciaGenero: true});
    }

//Ir a seccion de Inicio desde el menu de preferencias del usuario.
    volverInicio() {
        this.setState({obtenerPreferencia: false});
        this.setState({preferencia_usuario: ''});
    }

//Manejador de evento del boton "Eliminar" del menu de preferencias para cada preferencia dada.
    eliminarPreferencia(evento) {
        evento.preventDefault();
        const target = evento.target;
        const valor = JSON.parse(target.value);
        const id = target.id;
        var boton = document.getElementById(id);
        var str = boton.id;
        if (str.includes('genero')) {
            this.setState({generoEliminado: valor});
            this.eliminarGenero();
            this.obtenerSeccionPreferencia(this.state.preferencia_usuario);

        }
        if (str.includes('actor')) {
            this.setState({actorEliminado: valor});
            this.eliminarActor();
            this.obtenerSeccionPreferencia(this.state.preferencia_usuario);
        }
        if (str.includes('director')) {
            this.setState({directorEliminado: valor});
            this.eliminarDirector();
            this.obtenerSeccionPreferencia(this.state.preferencia_usuario);
        }
    }

//Eliminar preferencia dada(actor) según lo indicó el usuario.     
    eliminarActor() {
        fetch('/preferencias/1', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                    {
                        "idPreferencia": this.state.preferencia_usuario,
                        "actor": [this.state.actorEliminado],
                        "director": [],
                        "genero": []
                    }
            )
        });
    }

//Eliminar preferencia dada(director) según lo indicó el usuario.         
    eliminarDirector() {
        fetch('/preferencias/1', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                    {
                        "idPreferencia": this.state.preferencia_usuario,
                        "actor": [],
                        "director": [this.state.directorEliminado],
                        "genero": []
                    }
            )
        });
    }

//Eliminar preferencia dada(genero) según lo indicó el usuario.     
    eliminarGenero() {
        fetch('/preferencias/1', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                    {
                        "idPreferencia": this.state.preferencia_usuario,
                        "actor": [],
                        "director": [],
                        "genero": [this.state.generoEliminado]
                    }


            )
        });
    }

    //Obtenemos el director segun el iddirector especificado y el valor de verdad (true para listar nuevas preferencias), (false, para quitar de la lista, deschequeado).   

//Manejador de checks lista de nuevos actores a elegir segun preferencia del usuario. 
    manejadorCheckActores(evento) {
        const target = evento.target;
        const id = target.id;
        var Longitud = this.state.nuevaPreferenciaActor.length;
        var tomarPreferencia = this.state.nuevaPreferenciaActor;
        var checkBox = document.getElementById(id);
        var str = checkBox.id;
        
        if (checkBox.checked == true) {
            tomarPreferencia[Longitud] = JSON.parse(checkBox.value);
            this.setState({nuevaPreferenciaActor: tomarPreferencia});

        } else {
           var matches = str.match(/\d+/g); 
           const productos = this.state.nuevaPreferenciaActor.map(p => {
                    if (p.idActor == matches) {  
                      let temporalFiltroActor = tomarPreferencia.filter(filtrar => filtrar !== p);
                      this.setState({nuevaPreferenciaActor: temporalFiltroActor}); 
                      return p;
                    }
                    return p;
                    
                  });
        }
    }

//Manejador de checks lista de nuevos directores a elegir segun preferencia del usuario. 
    manejadorCheckDirectores(evento) {
       const target = evento.target;
        const id = target.id;
        var Longitud = this.state.nuevaPreferenciaDirector.length;
        var tomarPreferencia = this.state.nuevaPreferenciaDirector;
        var checkBox = document.getElementById(id);
        var str = checkBox.id;
        
        if (checkBox.checked == true) {
            tomarPreferencia[Longitud] = JSON.parse(checkBox.value);
            this.setState({nuevaPreferenciaDirector: tomarPreferencia});

        } else {
           var matches = str.match(/\d+/g); 
           const productos = this.state.nuevaPreferenciaDirector.map(p => {
                    if (p.idDirector == matches) {  
                      let temporalFiltroDirector = tomarPreferencia.filter(filtrar => filtrar !== p);
                      this.setState({nuevaPreferenciaDirector: temporalFiltroDirector}); 
                      return p;
                    }
                    return p;
                    
                  });
        }
    }

//Manejador de checks lista de nuevos generos a elegir segun preferencia del usuario.     
    manejadorCheckGeneros(evento) {
        const target = evento.target;
        const id = target.id;
        var Longitud = this.state.nuevaPreferenciaGenero.length;
        var tomarPreferencia = this.state.nuevaPreferenciaGenero;
        var checkBox = document.getElementById(id);
        var str = checkBox.id;
        
        if (checkBox.checked == true) {
            tomarPreferencia[Longitud] = JSON.parse(checkBox.value);
            this.setState({nuevaPreferenciaGenero: tomarPreferencia});

        } else {
           var matches = str.match(/\d+/g); 
           const productos = this.state.nuevaPreferenciaGenero.map(p => {
                    if (p.idGenero == matches) {  
                      let temporalFiltroGenero = tomarPreferencia.filter(filtrar => filtrar !== p);
                      this.setState({nuevaPreferenciaGenero: temporalFiltroGenero}); 
                      return p;
                    }
                    return p;
                    
                  });
        }
    }

//Llamada al servidor para pasar la lista de nuevas preferencias(actores) checkeadas por el usuario. 
    modificarPreferenciaActor(evento) {
        evento.preventDefault();
        fetch('/preferencias', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                    {
                        "idPreferencia": this.state.preferencia_usuario,
                        "actor": this.state.nuevaPreferenciaActor,
                        "director": [],
                        "genero": []
                    }
            )
        }
        );
        this.setState({editarPreferenciaActor: false});
        this.obtenerSeccionPreferencia(this.state.preferencia_usuario);
        this.setState({nuevaPreferenciaActor: []});
    }

//Llamada al servidor para pasar la lista de nuevas preferencias(directores)checkeadas por el usuario. 
    modificarPreferenciaDirector(evento) {
        evento.preventDefault();
        fetch('/preferencias', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                    {
                        "idPreferencia": this.state.preferencia_usuario,
                        "actor": [],
                        "director": this.state.nuevaPreferenciaDirector,
                        "genero": []
                    }
            )
        });
        this.setState({editarPreferenciaDirector: false});
        this.obtenerSeccionPreferencia(this.state.preferencia_usuario);
        this.setState({nuevaPreferenciaDirector: []});
    }

//Llamada al servidor para pasar la lista de nuevas preferencias(generos) checkeadas por el usuario. 
    modificarPreferenciaGenero(evento) {
        evento.preventDefault();
        fetch('/preferencias', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                    {
                        "idPreferencia": this.state.preferencia_usuario,
                        "actor": [],
                        "director": [],
                        "genero": this.state.nuevaPreferenciaGenero
                    }
            )
        });
        this.setState({editarPreferenciaGenero: false});
        this.obtenerSeccionPreferencia(this.state.preferencia_usuario);
        this.setState({nuevaPreferenciaGenero: []});
    }

    render() {
        if (this.state.obtenerPreferencia) {
            return (
                    <div>    
            <h2>Preferencias </h2>
                        <br/>
                        <div>
                        <div>
                            <table key="1">
                                <thead>
                                    <tr>                    
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {this.state.actoresPreferencia.map(actor =>
                                                <tr key = {actor.idActor}>
                                                    <td> {actor.nombre} </td>
                                                    <td> {actor.apellido} </td>       
                                                    <td><button className="boton-elimina" id={"buttonactor" + actor.idActor} value ={JSON.stringify(actor)
                                                                } onClick={this.eliminarPreferencia.bind(this)}>Eliminar</button></td>     
                                                </tr>
                                                )}
                                </tbody>
                                <br/>
                                <button className="boton-verde" onClick={this.obtenerPreferenciaActor.bind(this)} >Agregar</button>
                    
                            </table>
                        </div>
                    
                        <div>
                            <table key="2">
                                <thead>
                                    <tr>                    
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {this.state.directoresPreferencia.map(director =>
                                        <tr key = {director.idDirector}>
                                            <td> {director.nombre} </td>
                                            <td> {director.apellido} </td>       
                                            <td><button className="boton-elimina" id={"buttondirector" + director.idDirector} value = {JSON.stringify(director)} onClick={this.eliminarPreferencia.bind(this)}>Eliminar</button></td>     
                                        </tr>
                                        )} 
                                </tbody>
                                <br/>
                                <button className="boton-verde" onClick={this.obtenerPreferenciaDirector.bind(this)} >Agregar</button>
                    
                            </table>
                    
                        </div>     
                    
                    
                        <div>
                            <table key="3">
                                <thead>
                                    <tr>                    
                                        <th>Descripcion</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {this.state.generosPreferencia.map(genero =>
                                        <tr key = {genero.idGenero}>
                                            <td> {genero.descripcion} </td>       
                                            <td><button className="boton-elimina" id={"buttongenero" + genero.idGenero} value = {JSON.stringify(genero)} onClick={this.eliminarPreferencia.bind(this)}>Eliminar</button></td>     
                                        </tr>
                                        )}  
                                </tbody>
                                <br/>
                    
                                <button className="boton-verde" onClick={this.obtenerPreferenciaGenero.bind(this)} >Agregar</button>
                    
                            </table>
                         
                        </div>
                        </div>
                        
                        <div>
                            <button className="boton-volver" onClick={this.volverInicio.bind(this)}>Volver</button>
                            <button className="boton-simple" onClick={this.obtenerSeccionPreferencia.bind(this, this.state.preferencia_usuario)}>Refrescar</button>
                        </div>
                      

                       
                    </div>
                    );
        }

        if ((!this.state.obtenerPreferencia) && (!this.state.editarPreferenciaActor) && (!this.state.editarPreferenciaDirector) && (!this.state.editarPreferenciaGenero)) {
            return (
                    <div>
            <h2>Usuarios</h2>
                        <table>
                            <thead>
                                <tr>                    
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.usuarios.map(usuario =>
                                                <tr key = {usuario.idUsuario}>
                                                    <td> {usuario.nombre} </td>
                                                    <td> {usuario.apellido} </td>       
                                                    <td><button className="boton-verde" onClick={this.obtenerSeccionPreferencia.bind(this, usuario.idUsuario)}>Preferencia</button></td>     
                                                </tr>
                                            )}
                            </tbody>
                        </table>
                    </div>
                    );
        }

        if (this.state.editarPreferenciaActor) {
            return (
                    <div>
                        <br/> 
                         <h2>Actores</h2>
                        <table key="4">
                            <thead>
                                <tr>                    
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.actores.map(actor =>
                                                <tr key = {actor.idActor}>
                                                    <td> {actor.nombre} </td>
                                                    <td> {actor.apellido} </td>
                                                    <td> <input type="checkbox" id={"actor" + actor.idActor} value ={JSON.stringify(actor)} onClick={this.manejadorCheckActores.bind(this)}/></td>
                                    
                                                </tr>
                                            )}                                                        
                            </tbody>
                        </table>
                    
                        <div>
                            <button className="boton-verde" onClick={this.modificarPreferenciaActor.bind(this)}>Guardar</button>
                        </div>
                    </div>


                    );
        }
        if (this.state.editarPreferenciaDirector) {
            return (
                    <div>
                        <br/>
                        <h2>Directores</h2>                       
                        <table key="5">
                            <thead>
                                <tr>                    
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.directores.map(director =>
                                                <tr key = {director.idDirector}>
                                                    <td> {director.nombre} </td>
                                                    <td> {director.apellido} </td>
                                                    <td> <input type="checkbox" id={"director" + director.idDirector} value ={JSON.stringify(director)} onClick={this.manejadorCheckDirectores.bind(this)}/></td>
                                    
                                                </tr>
                                            )}                                                        
                            </tbody>
                        </table>
                    
                        <div>
                            <button className="boton-verde" onClick={this.modificarPreferenciaDirector.bind(this)}>Guardar</button>
                        </div>
                    </div>


                    );
        }


        if (this.state.editarPreferenciaGenero) {
            return (
                    <div>
                        <br/>     
                        <h2>Genero</h2>
                        <table key="6">
                            <thead>
                                <tr>                    
                                    <th>Descripcion</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.generos.map(genero =>
                                                <tr key = {genero.idGenero}>
                                                    <td> {genero.descripcion} </td>
                                                    <td> <input type="checkbox" id={"genero" + genero.idGenero} value ={JSON.stringify(genero)} onClick={this.manejadorCheckGeneros.bind(this)}/></td>
                                    
                                                </tr>
                                            )}                                                        
                            </tbody>
                        </table>
                    
                        <div>
                            <button className="boton-verde" onClick={this.modificarPreferenciaGenero.bind(this)}>Guardar</button>
                        </div>
                    </div>);
        }

    }
}
