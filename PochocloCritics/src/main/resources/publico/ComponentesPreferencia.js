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

//Actor obtenido por id para ser eliminado al hacer click en el boton eliminar.
    ObtenerActor(idactor) {
        fetch('/actor/' + idactor)
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({actorEliminado: datos});
                        }
                );
    }

//Director obtenido por id para ser eliminado al hacer click en el boton eliminar.
    ObtenerDirector(iddirector) {
        fetch('/director/' + iddirector)
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            this.setState({directorEliminado: datos});
                        }
                );
    }

    //Genero obtenido por id para ser eliminado al hacer click en el boton eliminar.
    ObtenerGenero(idgenero) {
        fetch('/generos/' + idgenero)
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            const valor = datos;
                            this.setState({generoEliminado: valor});
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
                        }
                );
        this.setState({obtenerPreferencia: true});
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
        const target = evento.target;
        const valor = target.value;
        const id = target.id;
        var boton = document.getElementById(id);
        var str = boton.id;

        if (str.includes('genero')) {
            this.ObtenerGenero(valor);
            this.eliminarGenero();
        }
        if (str.includes('actor')) {
            this.ObtenerActor(valor);
            this.eliminarActor();

        }
        if (str.includes('director')) {
            this.ObtenerDirector(valor);
            this.eliminarDirector();
        }
        this.obtenerSeccionPreferencia(this.state.preferencia_usuario);
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

//Obtenemos el actor segun el idactor especificado y el valor de verdad (true para listar nuevas preferencias), (false, para quitar de la lista, deschequeado).
    ObtenerActorChecked(idactor, valor)
    {
        fetch('/actor/' + idactor)
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            const actorObt = datos;
                            this.setState({actorObtenido: actorObt});
                            var Longitud = this.state.nuevaPreferenciaActor.length;
                            var tomarPreferencia = this.state.nuevaPreferenciaActor;
                            if (valor === true) {
                                tomarPreferencia[Longitud] = this.state.actorObtenido;
                                this.setState({nuevaPreferenciaActor: tomarPreferencia});
                            } else {
                                let temporalFiltroActor = tomarPreferencia.filter(filtrar => filtrar.idActor !== this.state.actorObtenido.idActor);
                                this.setState({nuevaPreferenciaActor: temporalFiltroActor});
                            }
                        }
                );
    }
    
 //Obtenemos el director segun el iddirector especificado y el valor de verdad (true para listar nuevas preferencias), (false, para quitar de la lista, deschequeado).   
    ObtenerDirectorChecked(iddirector, valor) {
        fetch('/director/' + iddirector)
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            const directorObt = datos;
                            this.setState({directorObtenido: directorObt});
                            var Longitud = this.state.nuevaPreferenciaDirector.length;
                            var tomarPreferencia = this.state.nuevaPreferenciaDirector;
                            if (valor === true) {
                                tomarPreferencia[Longitud] = this.state.directorObtenido;
                                this.setState({nuevaPreferenciaDirector: tomarPreferencia});
                            } else {
                                let temporalFiltroDirector = tomarPreferencia.filter(filtrar => filtrar.idDirector !== this.state.directorObtenido.idDirector);
                                this.setState({nuevaPreferenciaDirector: temporalFiltroDirector});
                            }
                        }
                );
    }
    
    
 //Obtenemos el genero segun el idgenero especificado y el valor de verdad (true para listar nuevas preferencias), (false, para quitar de la lista, deschequeado).
    ObtenerGeneroChecked(idgenero, valor) {
        fetch('/generos/' + idgenero)
                .then(respuesta => respuesta.json())
                .then(
                        datos => {
                            const generoObt = datos;
                            this.setState({generoObtenido: generoObt});
                            var Longitud = this.state.nuevaPreferenciaGenero.length;
                            var tomarPreferencia = this.state.nuevaPreferenciaGenero;
                            if (valor === true) {
                                tomarPreferencia[Longitud] = this.state.generoObtenido;
                                this.setState({nuevaPreferenciaGenero: tomarPreferencia});
                            } else {
                                let temporalFiltroGenero = tomarPreferencia.filter(filtrar => filtrar.idGenero !== this.state.generoObtenido.idGenero);
                                this.setState({nuevaPreferenciaGenero: temporalFiltroGenero});
                            }
                        }
                );
    }

//Manejador de checks lista de nuevos actores a elegir segun preferencia del usuario. 
    manejadorCheckActores(evento) {
        const target = evento.target;
        const valor = target.value;
        const id = target.id;
        var checkBox = document.getElementById(id);
        if (checkBox.checked === true) {
            this.ObtenerActorChecked(valor, true);
        } else
        {
            this.ObtenerActorChecked(valor, false);
        }
    }
    
//Manejador de checks lista de nuevos directores a elegir segun preferencia del usuario. 
    manejadorCheckDirectores(evento) {
        const target = evento.target;
        const valor = target.value;
        const id = target.id;
        var checkBox = document.getElementById(id);
        if (checkBox.checked === true) {
            this.ObtenerDirectorChecked(valor, true);
        } else
        {
            this.ObtenerDirectorChecked(valor, false);
        }
    }
    
//Manejador de checks lista de nuevos generos a elegir segun preferencia del usuario.     
    manejadorCheckGeneros(evento) {
        const target = evento.target;
        const valor = target.value;
        const id = target.id;
        var checkBox = document.getElementById(id);
        if (checkBox.checked === true) {
            this.ObtenerGeneroChecked(valor, true);
        } else
        {
            this.ObtenerGeneroChecked(valor, false);
        }
    }

//Llamada al servidor para pasar la lista de nuevas preferencias(actores) checkeadas por el usuario. 
    modificarPreferenciaActor() {
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
        this.obtenerSeccionPreferencia(this.state.preferencia_usuario);
        this.setState({editarPreferenciaActor: false});
        this.setState({nuevaPreferenciaActor: []});
    }

//Llamada al servidor para pasar la lista de nuevas preferencias(directores)checkeadas por el usuario. 
    modificarPreferenciaDirector() {
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
    modificarPreferenciaGenero() {
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
                        <h2>Mis Preferencias </h2>
                        <button className="boton-verde" onClick={this.obtenerPreferenciaActor.bind(this)} >Agregar</button>
                        <br/>
                        <div>
                            <table key="1">
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
                                    {this.state.actoresPreferencia.map(actor =>
                                        <tr key = {actor.idActor}>
                                            <td> {actor.idActor} </td>
                                            <td> {actor.nombre} </td>
                                            <td> {actor.apellido} </td>       
                                            <td><button className="boton-elimina" id={"buttonactor" + actor.idActor} value ={actor.idActor} onClick={this.eliminarPreferencia.bind(this)}>Eliminar</button></td>     
                                        </tr>
                        )}
                                </tbody>
                            </table>
                        </div>
                        <button className="boton-verde" onClick={this.obtenerPreferenciaDirector.bind(this)} >Agregar</button>
                    
                        <div>
                            <table key="2">
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
                                    {this.state.directoresPreferencia.map(director =>
                                        <tr key = {director.idDirector}>
                                            <td> {director.idDirector} </td>
                                            <td> {director.nombre} </td>
                                            <td> {director.apellido} </td>       
                                            <td><button className="boton-elimina" id={"buttondirector" + director.idDirector} value= {director.idDirector} onClick={this.eliminarPreferencia.bind(this)}>Eliminar</button></td>     
                                        </tr>
                        )} 
                                </tbody>
                            </table>
                    
                        </div>     
                    
                        <button className="boton-verde" onClick={this.obtenerPreferenciaGenero.bind(this)} >Agregar</button>
                    
                        <div>
                            <table key="3">
                                <thead>
                                    <tr>                    
                                        <th>IdGenero</th>
                                        <th>Descripcion</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {this.state.generosPreferencia.map(genero =>
                                        <tr key = {genero.idGenero}>
                                            <td> {genero.idGenero} </td>
                                            <td> {genero.descripcion} </td>       
                                            <td><button className="boton-elimina" id={"buttongenero" + genero.idGenero} value={genero.idGenero} onClick={this.eliminarPreferencia.bind(this)}>Eliminar</button></td>     
                                        </tr>
                        )}  
                                </tbody>
                            </table>
                        </div>
                        <div>
                            <button className="boton-simple" onClick={this.volverInicio.bind(this)}>Volver</button>
                        </div>
                    </div>
                    );
        }

        if ((!this.state.obtenerPreferencia) && (!this.state.editarPreferenciaActor) && (!this.state.editarPreferenciaDirector) && (!this.state.editarPreferenciaGenero)) {
            return (
                    <div>
                        <br/>                        
                        <table>
                            <thead>
                                <tr>                    
                                    <th>IdUsuario</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.usuarios.map(usuario =>
                                                <tr key = {usuario.idUsuario}>
                                                    <td> {usuario.idUsuario} </td>
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
                        <table key="4">
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
                                                    <td> <input type="checkbox" id={"actor" + actor.idActor} value ={actor.idActor} onClick={this.manejadorCheckActores.bind(this)}/></td>
                                    
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
                                                                <td> <input type="checkbox" id={"director" + director.idDirector} value ={director.idDirector} onClick={this.manejadorCheckDirectores.bind(this)}/></td>
                                                
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
                                                                <td> <input type="checkbox" id={"genero" + genero.idGenero} value ={genero.idGenero} onClick={this.manejadorCheckGeneros.bind(this)}/></td>
                                                
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
