import React, { Component } from 'react';
import SingleContact from './SingleContact';
import AddContact from './AddContact';



export default class Contacts extends Component {
    constructor(props){
        super(props);
        this.state = {
            contacts: [] // holds all information of the application
        }
    }

    componentDidMount(){
        // to fetch the data before we render
        fetch('http://localhost:8080/contacts')
            .then(response => response.json())
            .then(data => {
                this.setState({ contacts: data });
            });
    }

    render(){
        return(
            <div>
                <div className="row">
                    <AddContact />
                </div>
                <div className="row">
                        {this.state.contacts.map(contact => (
                            <SingleContact key={contact.id} contact={contact} />
                        ))}                    
                </div>
            </div>

        )
    }
}

