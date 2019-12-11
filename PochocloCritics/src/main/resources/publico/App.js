/* global ReactDOM */

class App extends React.Component {

    render() {
        
        return (
                <div>
                    <Header/>
                </div>
                );
    }
};

const Header = () => (
            <header>
                <h1>PochocloWeb</h1>        
            </header>
            );

ReactDOM.render(<App/>, document.getElementById('inicio'));