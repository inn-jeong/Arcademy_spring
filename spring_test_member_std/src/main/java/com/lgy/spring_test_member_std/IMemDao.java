package com.lgy.spring_test_member_std;

import java.util.ArrayList;
import java.util.HashMap;

public interface IMemDao {
	public ArrayList<MemDto> loginYn(HashMap<String, String> param);
	public void memberInsert(HashMap<String, String> param);
}
