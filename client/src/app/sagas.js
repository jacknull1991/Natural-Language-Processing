import { call, put, takeLatest } from 'redux-saga/effects';
import * as requests from '../requests';
import * as actions from './actions';

function* handleConnectToDB(action) {
	const res = yield call(requests.connectToDB, action.payload);
	const body = yield res.json();
	if (res.status === 200) {
		yield put(actions.setAppState({
			connected: true,
			connectErrorMsg: null,
			databaseUrl: body.databaseUrl,
		}));
	} else {
		yield put(actions.setAppState({
			connectErrorMsg: body.message
		}));
	}
}

function* sagas() {
	yield takeLatest(actions.CONNECT_TO_DB, handleConnectToDB);
}

export default sagas;