package jsoft.objects;

public class ClientObject extends UserObject {
	private int client_id;
	private String client_career_goals;
	private String client_profiles;

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_career_goals() {
		return client_career_goals;
	}

	public void setClient_career_goals(String client_career_goals) {
		this.client_career_goals = client_career_goals;
	}

	public String getClient_profiles() {
		return client_profiles;
	}

	public void setClient_profiles(String client_profiles) {
		this.client_profiles = client_profiles;
	}

}
