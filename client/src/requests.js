const request = (url, payload) => 
	fetch(url, {
		method: 'POST',
		headers: { 'Content-Type': 'application/json'},
		credentials: 'include',
		body: JSON.stringify(payload),
	});
	
export const connectToDB = ({ host, port, database, username, password }) =>
	request('/api/connect/db', { host, port, database, username, password });