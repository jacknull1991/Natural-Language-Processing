export const CONNECT_TO_DB = 'app/connect-to-db';
export const connectToDB = payload => ({
	type: CONNECT_TO_DB, payload,
});
export const SET_APP_STATE = 'app/set-app-state';
export const setAppState = payload => ({
	type: SET_APP_STATE, payload,
});