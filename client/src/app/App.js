import React, { Component } from 'react';
import logo from '../logo.svg';
import './App.css';
import AppNavbar from '../components/AppNavbar';
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';

class App extends Component {
	constructor() {
		super();
		this.handleSubmit = this.handleSubmit.bind(this);
	}
	
	handleSubmit(event) {
		event.preventDefault();
		const data = new FormData(event.target);
		
		fetch('/api/connect/db', {
			method: 'POST',
			body: data
		});
	}
	
	componentDidMound() {
		
	}
	
	render() {	
		return (
			<div className="App">
			<AppNavbar/>
	        <header className="App-header">
	          <img src={logo} className="App-logo" alt="logo" />
	          <div className="App-intro">
	            <h2>Natural Language Interface</h2>
	            <Label id="instruction">Connect to your database</Label>
	            <Form onSubmit={this.handleSubmit}>
	            	<FormGroup onSubmit={this.handleSubmit}>
	            		<Input type="text" name="host" id="host" placeholder="Host"/>
	            	</FormGroup>
            		<FormGroup>
	            		<Input type="text" name="port" id="port" placeholder="Port"/>
	            	</FormGroup>
	            	<FormGroup>
	            		<Input type="text" name="database" id="database" placeholder="Database"/>
	            	</FormGroup>
	            	<FormGroup>
	            		<Input type="text" name="username" id="username" placeholder="Username"/>
	            	</FormGroup>
	            	<FormGroup>
	            		<Input type="password" name="password" id="password" placeholder="Password"/>
	            	</FormGroup>
	            	<FormGroup>
	            		<Button id="connect" color="primary" type="submit">Connect</Button>
	            	</FormGroup>
	            </Form>
	           </div>
	        </header>
	      </div>	
		);
	}
}

export default App;
