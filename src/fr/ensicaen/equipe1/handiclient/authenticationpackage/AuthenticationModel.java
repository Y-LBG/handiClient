package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class AuthenticationModel {

	private AuthenticationActivity _authenticationActivity;
	private MainModel _mainModel;
	private String _activityDescription = "Entrer votre code PIN. Poser le nombre de doigts correspondant au chiffre souhait�. Z�ro correspond � dix doigts.";
	private String _pinCodeEnteredByUser = "";

	public AuthenticationModel(AuthenticationActivity authenticationActivity) {
		_authenticationActivity = authenticationActivity;
		_mainModel = MainModel.getInstance();
	}

	public String getControlType() {
		return _mainModel.getControlType();
	}

	public String getViewType() {
		return _mainModel.getViewType();
	}

	public void addNumberToPin(int i) {
		_pinCodeEnteredByUser += "" + i;
		
		// Notify View
		_authenticationActivity.getView().addStarToPinField();
	}

	public boolean cancelEntry() {
		int length = _pinCodeEnteredByUser.length();
		if (length == 0)
			return false;
		_pinCodeEnteredByUser = _pinCodeEnteredByUser.substring(0, length - 1);
		// Notify View
		_authenticationActivity.getView().removeStarFromPinField();
		
		return true;
	}

	public boolean verifyPIN() {
		if (_pinCodeEnteredByUser.equals(_mainModel.getPin()))
			return true;
		
		// Notify View
		//TODO Message de code erron�
		
		return false;
	}

	public String getActivityDescription() {
		return _activityDescription;
	}

}
