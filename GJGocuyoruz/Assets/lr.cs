using UnityEngine;
using System.Collections;

public class lr : MonoBehaviour {
	SpriteRenderer sr;
	public GameObject player;
	public float speed = 0.1f;
	// Use this for initialization
	void Start () {
		sr = this.GetComponent<SpriteRenderer> ();
		Transform player = this.transform;

	}
	
	// Update is called once per frame
	void Update () {
		if(Input.GetKeyDown(KeyCode.LeftArrow)){
			transform.position = Vector3.left * speed *  Time.deltaTime;
		}
	
	}
}
