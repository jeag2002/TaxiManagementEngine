package com.mytaxi.graphql.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://localhost:9000/graphql");
		
		String data = "{\"query\": \"query {findAllCars {id licenceplate engineType}}\"}";
		
		//String data = "{\"query\": \"{ post(id: '1') { id, text, comments { id, text} } }\"}";
		
		String token = "eyJraWQiOiJmY2x5UmNOUExjWkZMVFhULW9rdUJhQklSWFpIU0hsSHRWdGE5UjFYeEFzIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULlFYMzFzUkFGdzIwZExXX183ZmVxWm52SU85NXduRTQyWVduSXlCOGo3bUkiLCJpc3MiOiJodHRwczovL2Rldi02NTQ5MjMub2t0YXByZXZpZXcuY29tL29hdXRoMi9kZWZhdWx0IiwiYXVkIjoiYXBpOi8vZGVmYXVsdCIsImlhdCI6MTU0NjI4MDI1NSwiZXhwIjoxNTQ2MjgzODU1LCJjaWQiOiIwb2Fpb2ViZmo0WTFWNVNSVDBoNyIsInVpZCI6IjAwdWlvMzAzdTJWcXhXSnFzMGg3Iiwic2NwIjpbIm9wZW5pZCJdLCJzdWIiOiJqZWFnMjAwMkBnbWFpbC5jb20ifQ.xbbDfA9AaOGtur-rGT1yyJwSgIoMkPAP8FXBY9AuuDETQyN9wQpc_IJRsN-ZaK2fmTJB_DPUWzCp_KENWn9pgdkD1W-9HXM581gBtCR2m6_tpaU2yYs601oOM7HBOn-zrBlAcIdsGCADmJ3PWVmN8lTzT553R0QsXhykRYQrUmLCNxT_APUJ_tT6j7NvpqqGz7Vrnuv4AMxGpf-s4yUk_8JB8DkpDWV0ArhSM38orqwIWp0VKBLiSKPocuSUPRL9IEvXMY3qXuT0nWAPnwvnXXEc4TrrcCHyAG78ZX5kEnGX6KCiFiXRYZgsF9cc-GHAUGZvnWh1P_LRuFr6M-JPCA";
				
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        //conn.setRequestProperty("Authentication", "Bearer 00jx_eTqzMW38Eqa01Vn1pUNdyewmbYj02UW7Dpypf");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setRequestProperty("Content-Length", String.valueOf(data.getBytes("UTF-8").length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(data.getBytes("UTF-8"));
        
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        for (int c; (c = in.read()) >= 0;)
            System.out.print((char)c);
		
	}
	
	//https://dev-654923.oktapreview.com/oauth2/default/v1/authorize?request=eyJraWQiOiJmY2x5UmNOUExjWkZMVFhULW9rdUJhQklSWFpIU0hsSHRWdGE5UjFYeEFzIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULjZseDd3XzFSV01HN0gza0dHdlVlQkU1LWN2QS04Q19SWmVwenBDa2hjYzgiLCJpc3MiOiJodHRwczovL2Rldi02NTQ5MjMub2t0YXByZXZpZXcuY29tL29hdXRoMi9kZWZhdWx0IiwiYXVkIjoiYXBpOi8vZGVmYXVsdCIsImlhdCI6MTU0NjIwODUxOSwiZXhwIjoxNTQ2MjEyMTE5LCJjaWQiOiIwb2Fpb2ViZmo0WTFWNVNSVDBoNyIsInVpZCI6IjAwdWlvMzAzdTJWcXhXSnFzMGg3Iiwic2NwIjpbIm9wZW5pZCJdLCJzdWIiOiJqZWFnMjAwMkBnbWFpbC5jb20ifQ.PHrF1FOxuJ7N_wDfiWfQCcdLJV3YmwGaYkV1Z4ORnkrTrEpAOXULTiTrGWuKRfVVF5yMhU5UVtAUQ9L-POu01iU8J6T8GdMJ3OYZFzb9r8Jhjd3C4hQxAD6rY0hc4OGVId166i6JUtSTdJyJksz7PFJNtUJlq6XFkAJW0UpwR2KB1uWDz2TR32WLg5n7MURXgli7z3XYTPkhlNwDm_Uikoue9HhDjiEmW8faIzh8l_8w-lF3qChMc3ii7paHE-9D_6MSw2eYMYLVxTOrxhJqilqA4hMh5CF1noBId1bax5Eh0YtjCVzP4MMEYbkCY21K3n2D_09x1-b9ZOfVUPxPjg

}
