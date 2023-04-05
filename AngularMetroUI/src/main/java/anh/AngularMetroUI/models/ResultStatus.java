package anh.AngularMetroUI.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum ResultStatus {
	Ok,
    Fail,
    UnauthorizedRequest
}
