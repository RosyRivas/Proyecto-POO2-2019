class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            pagina : 1 // 1 preferencias, 2 publicar pelicula
        };
    }
    
    // determino la pagina a mostrar
    manejador(valor) {
        this.setState({pagina : valor});
    }

    
    render() {
        let componente;
        if (this.state.pagina === 1) {
            componente = <ComponentesPreferencia/>; 
        }
        if (this.state.pagina === 2) {
            componente = 'No hay nada todavía';
            componente = <ComponentesPelicula/>;
        }
        if (this.state.pagina === 3) {
            componente = 'No hay catalogo disponible';
           // componente = <ComponentesCatalogo/>;
        }
        
        

        // uso <span> y no <a> dado que no son enlaces a otras paginas
        // para que parezca un enlace en estilos.css defino el formato de span
        // paso a manejador() el id del componente que quiero mostrar
        // como cambio el estado, llama a render y muestra dicho componente
        return (
                <div>
                    <Header/>
                    <nav>
                        <span onClick={this.manejador.bind(this, 1)}>Preferencias</span> |
                        <span onClick={this.manejador.bind(this, 2)}>Publicar Película</span> |
                        <span onClick={this.manejador.bind(this, 3)}>Ver catalogo</span> |
                    </nav>
                    {componente}
                </div>
                );
    }
}

const Header = () => (
            <header>
                <h1>PochocloCritics</h1>        
            </header>
            );

ReactDOM.render(<App/>, document.getElementById('inicio'));
