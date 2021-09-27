package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.IReplyDao;
import com.example.dto.Reply;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements IReplyService {
	
	private final IReplyDao dao;

	@Transactional
	@Override
	public void write(Reply reply) throws Exception {
		
		if (reply.getRef() == 0) {
			List<HashMap<String, Integer>> ref = dao.getLastRef();
			if(ref.get(0) == null) {
				reply.setRef(1);
				dao.write(reply);
				
				return;
			} else {
				int x = ref.get(0).get("MAX(ref)");
				reply.setRef(x+1);
				dao.write(reply);
				
				return;
			}
			
		} else if (dao.isStepBigger(reply.getStep()).isEmpty()){
			int order = dao.getLastOrder(reply.getRef());
			reply.setRefOrder(order + 1);
			dao.write(reply);
		} else {
			int parentId = reply.getParentId();
			if(dao.eqStep(reply.getStep() ,parentId).get(0) == null) {
				log.info("empty :" + dao.eqStep(reply.getStep() ,parentId));
				reply.setRefOrder(reply.getRefOrder()+1);
				dao.write(reply);
			} else {
				log.info("not empty :" + dao.eqStep(reply.getStep() ,parentId));
				int ref = dao.eqStep(reply.getStep() ,parentId).get(0).get("MAX(ref_order)");
				reply.setRefOrder(ref+1);;
				dao.write(reply);
			}
		}
	}

	@Override
	public List<Reply> getReply(int id) throws Exception {
		
		List<Reply> list = dao.getReply(id);
		
		return list;
	}

}
