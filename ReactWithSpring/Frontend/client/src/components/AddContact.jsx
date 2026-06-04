import React, { Component } from 'react'
// copied from https://materializecss.com/text-inputs.html
export default class AddContact extends Component {
    constructor(props) {
        super(props);
        this.firstNameRef = React.createRef();
        this.lastNameRef = React.createRef();
        this.emailRef = React.createRef();
    }
    submitContact = (event) => {
        event.preventDefault();
        const newContact = {
                        firstName: this.firstNameRef.current.value,
                        lastName: this.lastNameRef.current.value,
                        email: this.emailRef.current.value
        }
        console.log(newContact);
        fetch("http://localhost:8080/api/contacts", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newContact)
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        window.location.reload();
    }

    render() {
        return (
            <div className="row">
                <form className="col s12" onSubmit={this.submitContact}>
                    <div className="row">
                        <div className="input-field col s6">
                            <input ref={this.firstNameRef} placeholder="Placeholder" id="first_name" type="text" className="validate" />
                            <label htmlFor="first_name">First Name</label>
                        </div>
                        <div className="input-field col s6">
                            <input ref={this.lastNameRef} id="last_name" type="text" className="validate" />
                            <label htmlFor="last_name">Last Name</label>
                        </div>
                    </div>
                    <div className="row">
                        <div className="input-field col s12">
                            <input ref={this.emailRef} id="email" type="email" className="validate" />
                            <label htmlFor="email">Email</label>
                        </div>
                    </div>

                    <div className="row">
                        <button className="btn waves-effect waves-light" type="submit" name="action">Submit
                        </button>
                    </div>
                </form>
            </div>
        
    )
}
}