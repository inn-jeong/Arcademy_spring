package com.lgy.spring_test_member_std;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemService {
	public int loginYn(HashMap<String, String> param);
	public void memberInsert(HashMap<String, String> param);
}
