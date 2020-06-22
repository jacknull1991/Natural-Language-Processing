import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import logo from './logo.svg';
import { Button, Input, Table, Container } from reactstrap;

class Query extends Component {
	
	componentDidMount() {
		// TODO
	}
	
	render() {
		
		return (
			<div className="App">
			<AppNavbar/>
	        <header className="App-header">
	          <img src={logo} className="App-logo" alt="logo" />
	          <Container className="themed-container" fluid={true}>
	            <h2>Natural Language Interface</h2>
	            <Form>
	            	<FormGroup>
	            		<Input type="text" id="usertext" placeholder="Enter your search here..."/> 
	            	</FormGroup>
	            </Form>
	           </Container>
	        </header>
	      </div>	
		); 
	}
}

export default Query;