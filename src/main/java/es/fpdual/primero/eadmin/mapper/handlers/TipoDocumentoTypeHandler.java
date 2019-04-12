package es.fpdual.primero.eadmin.mapper.handlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import es.fpdual.primero.eadmin.modelo.TipoDocumento;

@MappedTypes(TipoDocumento.class)
public class TipoDocumentoTypeHandler implements TypeHandler<TipoDocumento> {

	@Override
	public TipoDocumento getResult(ResultSet rs, String columnName) throws SQLException {
		return this.getTipoDocumento(rs.getString(columnName));
	}

	@Override
	public TipoDocumento getResult(ResultSet rs, int columnIndex) throws SQLException {
		return this.getTipoDocumento(rs.getString(columnIndex));
	}

	@Override
	public TipoDocumento getResult(CallableStatement cs, int collumIndex) throws SQLException {
		return this.getTipoDocumento(cs.getString(collumIndex));
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, TipoDocumento parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getId());
	}

	private TipoDocumento getTipoDocumento(String id) {
		return Arrays.stream(TipoDocumento.values()).filter(e -> e.getId().equals(id)).findFirst().orElse(null);
	}

}
