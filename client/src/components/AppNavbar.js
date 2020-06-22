import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarToggler, NavItem, NavLink } from 'reactstrap';

export default class AppNavbar extends Component {
	constructor(props) {
		super(props);
		this.state = {isOpen: false};
		this.toggle = this.toggle.bind(this);
	}
	
	toggle() {
		this.setState({
			isOpen: !this.state.isOpen
		});
	}
	
	render() {
		return <Navbar color="dark" dark expand="md">
			<NavbarToggler onClick={this.toggle}></NavbarToggler>
			<Collapse isOpen={this.state.isOpen} navbar>
				<Nav className="ml-auto" navbar>
					<NavItem>
						<NavLink href="https://github.com/jacknull1991/Natural-Language-Processing">Github</NavLink>
					</NavItem>
				</Nav>
			</Collapse>
		</Navbar>;
	}
}