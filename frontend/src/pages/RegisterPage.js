import React from 'react';
import styled from 'styled-components';
import {
  Button,
  Checkbox,
  FormControlLabel,
  TextField,
  Typography,
} from '@material-ui/core';
import { Link } from 'react-router-dom';
import CancelIcon from '@material-ui/icons/Cancel';
import SendIcon from '@material-ui/icons/Send';

import { routes } from '../routes';

const Wrapper = styled.div`
  height: 100vh;

  width: 50%;
  max-width: 500px;

  background-color: #ebeeef;
  box-shadow: -5px -5px 10px 5px;

  position: relative;

  display: flex;
  justify-content: center;
  align-items: center;
`;

const Close = styled(Link)`
  width: 24px;
  height: 24px;

  position: absolute;
  top: 10px;
  left: 10px;
  color: gray;
`;

const Container = styled.div`
  margin: 0 50px;

  width: 90%;
`;

const HeaderTitle = styled.div`
  display: block;

  font-size: 28px;
  font-weight: 700;
  color: rgba(0, 0, 0, 0.54);

  margin-bottom: 20px;
  text-align: center;
`;

const Form = styled.form`
  width: 100%;

  margin-bottom: 30px;
`;

const ButtonWrapper = styled.div`
  margin-top: 20px;

  display: flex;
  justify-content: flex-end;
`;

const ButtonContainer = styled.div`
  width: 50%;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
`;

const RegisterPage = () => {
  return (
    <Wrapper>
      <Close to={routes.home}>
        <CancelIcon />
      </Close>
      <Container>
        <HeaderTitle>Register Form</HeaderTitle>
        <Form>
          <TextField
            color='primary'
            fullWidth
            label='First Name'
            required
            variant='filled'
            margin='dense'
          />
          <TextField
            color='primary'
            fullWidth
            label='Last Name'
            required
            variant='filled'
            margin='dense'
          />
          <TextField
            color='primary'
            fullWidth
            label='Login / Username'
            required
            variant='filled'
            margin='dense'
          />
          <TextField
            color='primary'
            fullWidth
            label='Email'
            required
            variant='filled'
            margin='dense'
            type='email'
          />
          <TextField
            color='primary'
            fullWidth
            label='Password'
            required
            variant='filled'
            margin='dense'
            type='password'
          />
          <TextField
            color='primary'
            fullWidth
            label='Retype Password'
            required
            variant='filled'
            margin='dense'
            type='password'
          />
          <FormControlLabel
            control={<Checkbox required />}
            label='I accept the Terms of Use and Privacy Policy'
          ></FormControlLabel>
          <ButtonWrapper>
            <ButtonContainer>
              <Button
                type='submit'
                variant='contained'
                color='primary'
                endIcon={<SendIcon />}
                size='large'
                fullWidth
              >
                SIgn UP
              </Button>
            </ButtonContainer>
          </ButtonWrapper>
        </Form>
        <Typography align='center' color='textSecondary' variant='subtitle2'>
          Already have an account -{' '}
          <StyledLink to={routes.login}>Login</StyledLink>
        </Typography>
      </Container>
    </Wrapper>
  );
};

export default RegisterPage;
