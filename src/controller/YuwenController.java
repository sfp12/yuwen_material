package controller;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;

import model.Material;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.glassfish.gmbal.ParameterNames;

import dao.MaterialDao;

@Controller
public class YuwenController {
	
	private MaterialDao mDao;

	@RequestMapping(value="/material")
    public ModelAndView material(){		
        ModelAndView mv = new ModelAndView();        
        mv.setViewName("material");        
        return mv;
    }
	
	@RequestMapping(value="/resources/material/materials")
	@ResponseBody	
    public List test(@RequestParam("jiansuoxiang") String jiansuoxiang, @RequestParam("pipei") String pipei, @RequestParam("cong") String cong, @RequestParam("dao") String dao, @RequestParam("jiansuoci") String jiansuoci) throws Exception{
		
		jiansuoxiang = URLDecoder.decode(jiansuoxiang, "utf-8");
		pipei = URLDecoder.decode(pipei, "utf-8");
		cong = URLDecoder.decode(cong, "utf-8");
		dao = URLDecoder.decode(dao, "utf-8");
		jiansuoci = URLDecoder.decode(jiansuoci, "utf-8");
		String sql = "";
		if(jiansuoci.length() != 0){
			if(pipei.equals("模糊")){
				pipei = "like";
				jiansuoci = "%"+jiansuoci+"%";
			}else{
				pipei = "=";
				jiansuoci = jiansuoci;
			}
			if(jiansuoxiang.equals("xuanwentimu") && pipei.equals("=")){
				sql="select * from qianqi1900_1949 where (xuanwentimu = '"+jiansuoci+"' or timubieming = '"+jiansuoci+"')  and (nianfen between "+cong+" and "+dao+")";
			}else{
				sql="select * from qianqi1900_1949 where ("+jiansuoxiang+" "+pipei+" '"+jiansuoci+"') and (nianfen between "+cong+" and "+dao+")";
			}
		}else{
			if(pipei.equals("模糊")){
				pipei = "like";				
			}else{
				pipei = "=";				
			}
			sql="select * from qianqi1900_1949 where nianfen between "+cong+" and "+dao;
		}		
		
		System.out.println("sql:"+sql);
		List<Material> l = new ArrayList<Material>();
		Connection conn=DbUtil.getCon();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
	
		while(rs.next()){
			
			Material m = new Material();
			m.setId(rs.getInt("id"));
			m.setNianfen(rs.getInt("nianfen"));
			m.setBanben(rs.getInt("banben"));
			m.setXuanwentimu(rs.getString("xuanwentimu"));
			m.setZuozhe(rs.getString("zuozhe"));
			m.setYizhe(rs.getString("yizhe"));
			m.setTicai(rs.getString("ticai"));
			m.setTicai1(rs.getString("ticai1"));
			m.setShidai(rs.getString("shidai"));
			m.setShidai1(rs.getString("shidai1"));
			m.setGuobie(rs.getString("guobie"));
			m.setGuobie1(rs.getString("guobie1"));
			m.setJiaokeshuming(rs.getString("jiaokeshuming"));
			m.setJiaokeshubianzhuzhe(rs.getString("jiaokeshubianzhuzhe"));
			m.setCebie(rs.getString("cebie"));
			m.setCebie1(rs.getString("cebie1"));
			m.setChubandi(rs.getString("chubandi"));
			m.setChubanshe(rs.getString("chubanshe"));
			m.setXuanwenmoju(rs.getString("xuanwenmoju"));
			m.setXuanwenshouju(rs.getString("xuanwenshouju"));
			m.setTimubieming(rs.getString("timubieming"));
			m.setZuozhebieming(rs.getString("zuozhebieming"));
			m.setBeuzhu(rs.getString("beizhu"));			
			
			l.add(m);
		}
		    
        return l;
    }
	
}
