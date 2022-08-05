package com.barogo.api.config.secuirity;

/**
 * jwt 인증 필터
 *  */
//@Data
//@EqualsAndHashCode(callSuper=false)
//public class ApiAuthFilter extends OncePerRequestFilter {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
//
//        GuideResult result = new GuideResult();
//        ServletRequestDataBinder binder = new ServletRequestDataBinder(result);
//        binder.setValidator(validator);
//        binder.setConversionService(conversionService);
//        binder.bind(req);
//        binder.validate();
//
//        MetadataHolder.CURRENT_STEP_MEMBER_ID.set(req.getHeader("reqMemberId"));
//        MetadataHolder.CURRENT_STEP_ADV_ID.set(req.getHeader("advId"));
//        MetadataHolder.CURRENT_STEP_VENDOR_ID.set(req.getHeader("vendorId"));
//
//        chain.doFilter(req, resp);
//    }
//
//
//}
