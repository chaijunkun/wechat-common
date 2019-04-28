package com.github.chaijunkun.wechat.common.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 参与金融计算的BigDecimal类型序列化器
 * @author chaijunkun
 * @since 2015年4月17日
 */
public class MoneyBigDecimalSerializer extends JsonSerializer<BigDecimal> {
	
	private static final DecimalFormat format;
	
	static {
		format = new DecimalFormat("0.00");
		format.setRoundingMode(RoundingMode.HALF_UP);
	}

	@Override
	public void serialize(BigDecimal value, JsonGenerator jgen,	SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeNumber(format.format(value));
	}

}
